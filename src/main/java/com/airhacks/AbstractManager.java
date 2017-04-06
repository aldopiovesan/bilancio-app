/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
public abstract class AbstractManager {

    public final String SUCCESS = "SUCCESS";
    public final String FAILURE_DATA_ALREADY_PRESENT = "FAILURE_DATA_ALREADY_PRESENT";
    public final String FAILURE_DATA_NOT_VALID = "FAILURE_DATA_NOT_VALID";
    
    @PersistenceContext
    EntityManager em;
}
