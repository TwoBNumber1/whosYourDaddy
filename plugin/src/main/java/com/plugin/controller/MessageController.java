package com.plugin.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.plugin.entity.CqMessage;
import com.plugin.entity.CqMessageResponse;
import com.plugin.entity.PrivateMessage;
import com.plugin.service.serviceImpl.CqServiceImpl;
import com.plugin.util.ConvertUtil;




/**
 * 上报信息管理
 * @author LAO
 *
 */
@Controller
public class MessageController {
	
	//转换工具类
	private final ConvertUtil convertUtil;
	//服务类
	private  CqServiceImpl cqServiceImpl;
	//去除cq码图片的正则表达式
    private static String singleImgRegex = "\\[CQ:image,file=(.+)\\]";
    //验证是否@
    private static String singleAtRegex = "\\[CQ:at,qq=(.+)\\]";
    //日志文件
    private Logger logger = LogManager.getLogger(this.getClass());
    
    @Autowired
    public MessageController(ConvertUtil convertUtil,CqServiceImpl cqServiceImpl) {
		// TODO Auto-generated constructor stub
    	this.convertUtil = convertUtil;
    	this.cqServiceImpl = cqServiceImpl;
	}
	
	@RequestMapping(value="/cqAPI" ,method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	//RequestBody读取Request请求的body部分
	public @ResponseBody CqMessageResponse recieveMessage(@RequestBody CqMessage cqMessage) {
		
		logger.info("=接收到http api 上报的消息");
		//Map<String,Object> modelMap = null;
		CqMessageResponse msgResponse = null;
	  	//收到消息
        String message = cqMessage.getMessage();
    	//将消息中的cq码图片信息分离
        message = message.replaceAll("&#91;", "[");
        message = message.replaceAll("&#93;", "]");
        String messageWithOutImage = message.replaceAll(singleImgRegex, "");
        //待整理
        switch (cqMessage.getPostType()){
      
            case "message":
                //识别消息类型
                switch (cqMessage.getMessageType()) {
                	//私聊消息
	                case "private":
	                		
	            		//将字段中的时间戳转换成时间
	            		/*Long timeStamp =  new Long(Long.parseLong(cqMessage.getTime())) * 1000L;
	            		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	            		Date date = new Date(timeStamp);*/
	                	logger.info("私聊消息记录");
	            		PrivateMessage privateMessage = new PrivateMessage();
	            		privateMessage.setMessage(messageWithOutImage);
	            		privateMessage.setMessageTime(convertUtil.timeStampToTime(cqMessage.getTime()));
	            		privateMessage.setSenderId(cqMessage.getUserId());
	            		privateMessage.setMessageFont(0);
	            		
	            		int result = cqServiceImpl.insertMessage(privateMessage);
	            		if(result > 0) {
	            			logger.info("消息记录保存成功！");
	            			System.out.println(privateMessage);
	            		}else {
	            			logger.info("消息记录保存失败！");
	            		}
	            		
	            		/*//如何响应??  抽取方法?  map响应
	            		modelMap = new HashMap<String,Object>();
	            		modelMap.put("reply", "真的一天到晚吵吵，烦死了你");*/
	            		//对象响应
	            		msgResponse = new CqMessageResponse();
	            		msgResponse.setReply("回复消息");
	            		
	                    break;    
	                //群消息
	                case "group":
	                	logger.info("群消息---");
	                	
	                	logger.info(messageWithOutImage);
	                	Pattern pattern = Pattern.compile(singleAtRegex);
	                	Matcher matcher = pattern.matcher(messageWithOutImage);
	                	//正则表达式 当@机器人时才做回复(可以添加其他的统一回复)
	                	if(matcher.find()) {
	                		msgResponse = new CqMessageResponse();
	                		msgResponse.setReply("谁？我？我吗？");
	                		msgResponse.setAtSender(true);
	                	}
	                	
                        break;
                    //讨论组消息
                    case "discuss":
                    	logger.info("讨论组消息---");
                        break;
                    //其他消息(API暂未定义)
                    default:
                    	logger.info("出现了api尚未定义的消息 可能需要更新插件");
                    	break;
                }
                break;
            //群、讨论组变动等非消息类事件
            case "event":
            	
            	break;
            //加好友、加群请求/邀请
            case "request":
            	//可以直接响应 或者通过flag字段的值发送请求来响应
            	System.out.println("好友请求/加群请求、邀请---");
        		System.out.println("-----request--sub_type : " + cqMessage.getRequestType());
            	System.out.println("-----request--user_id : " + cqMessage.getUserId());
        		System.out.println("-----request--sub_type : " + cqMessage.getSubType());
        		System.out.println("-----request--group_id : " + cqMessage.getGroupId());
        		System.out.println("-----request--flag : " + cqMessage.getFlag());
        		System.out.println("-----request--time : " + convertUtil.timeStampToTime(cqMessage.getTime()));
        		
        		//不作响应现在
        	/*	modelMap = new HashMap<>();
        		modelMap.put("approve", true);
        		modelMap.put("reason","群主太丑");*/
            	
            	break;
		//返回一个逻辑视图名
		//暂时没有需要返回的逻辑视图名字'
            
        }
        return msgResponse;
	}
	
	//抽取到工具类中
	/*	private static String timeStampToTime(String timeStampString) {
		
		long timeStampLong =  (Long.parseLong(timeStampString))*1000L ;
		SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return simpleDateFormat.format(new Date(timeStampLong));
	}
	*/
	
}
