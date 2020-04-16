/*
 * ELAINE CECILIA GATTO
 * 2020-04-16
 * MULTILABEL R CSV TO ARFF
 */
package r_csv_2_arff;

import weka.core.*;
import java.io.*;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.*;
import weka.filters.unsupervised.attribute.NumericToNominal;

public class R_csv_2_arff {

    public static void main(String[] args) throws IOException, Exception {
        
        String arquivo1 = args[0];
	String arquivo2 = args[1];
        String faixa = args[2];  
	    
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(arquivo1));
        
        Instances data = loader.getDataSet();     
        
        data.setClassIndex(data.numAttributes() - 1);        
        NumericToNominal Nominalize = new NumericToNominal();
        String[] options = new String[2];
        options[0] = "-R";        
        options[1] = faixa; //set the attributes from indices 1 to 2 as        
               
        //nominal
        Nominalize.setOptions(options);
        Nominalize.setInputFormat(data);
        Instances data1 = Filter.useFilter(data, Nominalize);  

        // save ARFF
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data1);
        saver.setFile(new File(arquivo2));
        saver.writeBatch();
        
        System.out.print("\n FIM");
    }

}
