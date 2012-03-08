package com.unitt.servicemanager.websocket;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonValue;

import java.io.Serializable;
import java.util.Date;


public class MessageRoutingInfo implements Serializable
{
    public enum MessageResultType
    {
        Error,
        CompleteSuccess,
        PartialSuccess;


        @Override
        public String toString() {
           return Integer.toString(ordinal());
        }
    }
    
    private static final long serialVersionUID = 3745930724237990205L;
    
    private String sessionId;
    private String requestId;
    private String serviceName;
    private String methodSignature;
    private int    timeToLiveInMillis;
    private Date   sent;
    private String uid;
    private String webSocketId;
    private String serverId;
    private Short serializerType;
    private MessageResultType resultType;


    // constructors
    // ---------------------------------------------------------------------------
    public MessageRoutingInfo()
    {
        //default
    }

    public MessageRoutingInfo(MessageRoutingInfo aOriginal)
    {
        setSessionId(aOriginal.getSessionId());
        setRequestId(aOriginal.getRequestId());
        setServiceName(aOriginal.getServiceName());
        setMethodSignature(aOriginal.getMethodSignature());
        setTimeToLiveInMillis(aOriginal.getTimeToLiveInMillis());
        setSent(aOriginal.getSent());
        setUid(aOriginal.getUid());
        setWebSocketId(aOriginal.getWebSocketId());
        setServerId(aOriginal.getServerId());
        setSerializerType(aOriginal.getSerializerType());
        setResultType(aOriginal.getResultType());
    }

    
    // getters & setters
    // ---------------------------------------------------------------------------
    public String getSessionId()
    {
        return sessionId;
    }

    public void setSessionId( String aSessionId )
    {
        sessionId = aSessionId;
        uid = getSessionId() + "::" + getRequestId();
    }

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId( String aRequestId )
    {
        requestId = aRequestId;
        uid = getSessionId() + "::" + getRequestId();
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName( String aServiceName )
    {
        serviceName = aServiceName;
    }

    public String getMethodSignature()
    {
        return methodSignature;
    }

    public void setMethodSignature( String aMethodSignature )
    {
        methodSignature = aMethodSignature;
    }

    public int getTimeToLiveInMillis()
    {
        return timeToLiveInMillis;
    }

    public void setTimeToLiveInMillis( int aTimeToLiveInMillis )
    {
        timeToLiveInMillis = aTimeToLiveInMillis;
    }

    public Date getSent()
    {
        return sent;
    }

    public void setSent( Date aSent )
    {
        sent = aSent;
    }

    public String getWebSocketId()
    {
        return webSocketId;
    }

    public void setWebSocketId( String aWebsocketId )
    {
        webSocketId = aWebsocketId;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid( String aUid )
    {
        uid = aUid;
    }

    public String getServerId()
    {
        return serverId;
    }

    public void setServerId( String aServerId )
    {
        serverId = aServerId;
    }
    
    public Short getSerializerType()
    {
        return serializerType;
    }

    public void setSerializerType( Short aSerializerType )
    {
        serializerType = aSerializerType;
    }

    @JsonIgnore
    public MessageResultType getResultType()
    {
        return resultType;
    }

    @JsonProperty("resultType")
    public int getResultTypeAsInt() {
        if (resultType != null) {
            return getResultType().ordinal();
        }

        return -1;
    }

    public void setResultType( MessageResultType aResultType )
    {
        resultType = aResultType;
    }
    

    // Object overrides
    // ------------------------------------------------
    @Override
    public String toString()
    {
        return "MessageRoutingInfo [serverId= " + serverId + ", websocketId=" + webSocketId + ", sessionId=" + sessionId + ", requestId=" + requestId + ", uid=" + uid + ", serviceName=" + serviceName + ", methodSignature=" + methodSignature + ", serializerType=" + serializerType + ", sent=" + sent + ", timeToLiveInMills=" + timeToLiveInMillis + ", resultType=" + resultType + "]";
    }
}
