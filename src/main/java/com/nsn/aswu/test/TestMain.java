/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test;

import com.nsn.aswu.test.entity.Alarm;
import com.nsn.aswu.test.entity.NetworkElement;
import com.nsn.aswu.test.repository.AlarmRepository;
import com.nsn.aswu.test.repository.NetworkElementRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yan Shanli
 * @date 7/28/2016
 */
public class TestMain
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext( RootConfig.class );
        NetworkElementRepository repository = context.getBean( NetworkElementRepository.class );
        Alarm alarm = new Alarm();
        alarm.setAlarmText( "test" );
        List<Alarm> alarmList=new ArrayList<>(  );
        alarmList.add( alarm );

        NetworkElement ne = new NetworkElement();
        ne.setDn( "DN-1/ne-1" );
        ne.setName( "ne-1" );
        ne.setAlarmList(alarmList  );

        repository.save( ne );
        repository.flush();

        System.out.println( ne.getId() );
    }
}
