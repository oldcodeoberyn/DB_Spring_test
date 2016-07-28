/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Yan Shanli
 * @date 7/28/2016
 */
@Entity
public class Alarm
{
    @Id
    private long id;
    private String alarmingObjectDn;
    private String alarmingObjectName;
    @Enumerated( EnumType.STRING )
    private Severity severity;
    private String alarmText;
    private Integer alarmNo;
    private String alarmType;
    private String alarmTime;
    private String ackStatus;
    private String supplementaryInfo;
    private String diagnosticInfo;

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getAlarmingObjectDn()
    {
        return alarmingObjectDn;
    }

    public void setAlarmingObjectDn( String alarmingObjectDn )
    {
        this.alarmingObjectDn = alarmingObjectDn;
    }

    public String getAlarmingObjectName()
    {
        return alarmingObjectName;
    }

    public void setAlarmingObjectName( String alarmingObjectName )
    {
        this.alarmingObjectName = alarmingObjectName;
    }

    public Severity getSeverity()
    {
        return severity;
    }

    public void setSeverity( Severity severity )
    {
        this.severity = severity;
    }

    public String getAlarmText()
    {
        return alarmText;
    }

    public void setAlarmText( String alarmText )
    {
        this.alarmText = alarmText;
    }

    public Integer getAlarmNo()
    {
        return alarmNo;
    }

    public void setAlarmNo( Integer alarmNo )
    {
        this.alarmNo = alarmNo;
    }

    public String getAlarmType()
    {
        return alarmType;
    }

    public void setAlarmType( String alarmType )
    {
        this.alarmType = alarmType;
    }

    public String getAlarmTime()
    {
        return alarmTime;
    }

    public void setAlarmTime( String alarmTime )
    {
        this.alarmTime = alarmTime;
    }

    public String getAckStatus()
    {
        return ackStatus;
    }

    public void setAckStatus( String ackStatus )
    {
        this.ackStatus = ackStatus;
    }

    public String getSupplementaryInfo()
    {
        return supplementaryInfo;
    }

    public void setSupplementaryInfo( String supplementaryInfo )
    {
        this.supplementaryInfo = supplementaryInfo;
    }

    public String getDiagnosticInfo()
    {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo( String diagnosticInfo )
    {
        this.diagnosticInfo = diagnosticInfo;
    }
}
