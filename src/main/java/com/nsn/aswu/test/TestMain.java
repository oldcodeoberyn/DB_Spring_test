/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nsn.aswu.test.entity.Alarm;
import com.nsn.aswu.test.entity.NetworkElement;
import com.nsn.aswu.test.repository.AlarmRepository;
import com.nsn.aswu.test.repository.NetworkElementRepository;

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
        AlarmRepository alarmRepository = context.getBean( AlarmRepository.class );

        NetworkElement ne = new NetworkElement();
        ne.setDn( "DN-1/ne-1" );
        ne.setName( "ne-1" );

        List<Alarm> alarmList = new ArrayList<>();
        for( Integer i = 0; i < 10; i++ )
        {
            Alarm alarm = new Alarm();
            alarm.setAlarmText( "test" + i );
            alarm.setNetworkElement( ne );
            alarmList.add( alarm );
        }

        ne.setAlarmList( alarmList );

        repository.save( ne );

        alarmRepository.save( alarmList );
        List<Alarm> allAlarms = alarmRepository.findAll();
        printAlarmData("findAll", allAlarms);
        allAlarms = alarmRepository.findByIdBetween( 2L,6L );
        printAlarmData("findByIdBetween", allAlarms);
        allAlarms = alarmRepository.findByIdLessThan( 5L );
        printAlarmData("findByIdLessThan", allAlarms);
        allAlarms = alarmRepository.findByIdGreaterThan( 5L );
        printAlarmData("findByIdGreaterThan", allAlarms);
        allAlarms = alarmRepository.findByAlarmTextLike( "test1" );
        printAlarmData("findByAlarmTextLike", allAlarms);
        allAlarms = alarmRepository.findByAlarmTextNotLike( "test1" );
        printAlarmData("findByAlarmTextNotLike", allAlarms);
        allAlarms = alarmRepository.findByAlarmTextNot( "test1" );
        printAlarmData("findByAlarmTextNot", allAlarms);
        Collection<String> wantedAlarm = new ArrayList<String>(  );
        wantedAlarm.add( "test1" );
        wantedAlarm.add( "test3" );
        wantedAlarm.add( "test5" );
        allAlarms = alarmRepository.findByAlarmTextIn( wantedAlarm );
        printAlarmData("findByAlarmTextIn", allAlarms);

    }

    private static void printAlarmData(String ifName, List<Alarm> alarms)
    {
        System.out.printf( String.format( "$$$$$$$$$$$$$$$$$$$$$$ %s $$$$$$$$$$$$$$$$$$$$$$\r\n", ifName ));
        for( Alarm alarm : alarms )
        {
            System.out.printf( "Alarm id: %d, Alamr Text: %s \r\n", alarm.getId(), alarm.getAlarmText() );
        }
    }
}
