/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test.repository;

import com.nsn.aswu.test.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author Yan Shanli
 * @date 7/28/2016
 */

public interface AlarmRepository extends JpaRepository<Alarm,Long>
{
    List<Alarm> findByIdBetween(Long before, Long after);

    List<Alarm> findByIdLessThan( long max );

    List<Alarm> findByIdGreaterThan( long min );

    List<Alarm> findByAlarmTextLike( String alarmText );

    List<Alarm> findByAlarmTextNotLike( String alarmText );

    List<Alarm> findByAlarmTextNot( String alarmText );

    List<Alarm> findByAlarmTextIn( Collection<String> wantedAlarm );
}
