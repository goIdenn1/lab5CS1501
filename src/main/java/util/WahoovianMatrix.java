package util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import org.apache.commons.math3.linear.RealMatrix;

public class WahoovianMatrix {
    
    private static final Logger logger = LogManager.getLogger();

    public static RealMatrix wahoovian(RealMatrix c) {
        Configurator.setLevel(logger.getName(), Level.TRACE);
        logger.info("Entering WahoovianMatrix");
        int rows = 0;
        int columns = 0;
       
        for(int i = 0; i < c.getRow(0).length;i++){
            rows ++;
        }
       
        for(int i = 0; i < c.getColumn(0).length;i++){
            columns++;
        }
        if(rows == columns){
            RealMatrix transpose = c.transpose();
            RealMatrix wahoovian = transpose.scalarMultiply(-1);
            logger.info("Exiting WahoovianMatrix");
            return(wahoovian);
        }
        else{
            logger.error("RealMatrix c is not square");
            logger.info("Exiting WahoovianMatrix");
            return(c);
            
        }
    }
}