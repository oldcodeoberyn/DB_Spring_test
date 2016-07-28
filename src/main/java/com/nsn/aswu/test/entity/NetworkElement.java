/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Yan Shanli
 * @date 7/28/2016
 */
@Entity
public class NetworkElement
{
    @Id
    private long id;
    private String dn;
    private String name;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn( name = "ne_id", nullable = false )
    private List<Alarm> alarmList;

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getDn()
    {
        return dn;
    }

    public void setDn( String dn )
    {
        this.dn = dn;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Alarm> getAlarmList()
    {
        return alarmList;
    }

    public void setAlarmList( List<Alarm> alarmList )
    {
        this.alarmList = alarmList;
    }


}
