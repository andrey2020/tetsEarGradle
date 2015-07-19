/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andreynikolaev;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author <a href="mailto:ich@andrey-nikolaev.net">Andrey Nikolaev</a>
 */
@Stateless
@Remote(RemoteCalculator.class)
public class CalculatorBean implements RemoteCalculator {
    private static final Logger logger = LogManager.getLogger(CalculatorBean.class);
    
    @Override
    public int add(int a, int b) {
        logger.info("Input: a = " + a + ", b = " + b);
        return a + b;
    }
 
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
