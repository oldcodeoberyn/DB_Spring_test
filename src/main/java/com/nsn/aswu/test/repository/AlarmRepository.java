/*
 * Copyright (c) 2016 Nokia Solutions and Networks. All rights reserved.
 */

package com.nsn.aswu.test.repository;

import com.nsn.aswu.test.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yan Shanli
 * @date 7/28/2016
 */
public interface AlarmRepository extends JpaRepository<Alarm,Long>
{
}
