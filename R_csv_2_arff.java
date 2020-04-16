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

/**
 *
 * @author elain
 */
public class R_csv_2_arff {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        
        String arquivo1 = args[0];
	String arquivo2 = args[1];
        String faixa = args[2];        
        
        //String arquivo1 = "C:\\Users\\elain\\PartitionsJaccard10Fold\\Partitions\\emotions\\Tr\\Split-1\\particao_2\\grupo_1\\grupo_Tr_1.csv";
        //String arquivo2 = "C:\\Users\\elain\\PartitionsJaccard10Fold\\Partitions\\emotions\\Tr\\Split-1\\particao_2\\grupo_1\\grupo_Tr_1.arff";        
        
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(arquivo1));
        
        Instances data = loader.getDataSet();
        //System.out.println("\n" + data + "\n");        
        
        data.setClassIndex(data.numAttributes() - 1);        
        NumericToNominal Nominalize = new NumericToNominal();
        String[] options = new String[2];
        options[0] = "-R";        
        options[1] = faixa; //set the attributes from indices 1 to 2 as        
               
        //nominal
        Nominalize.setOptions(options);
        Nominalize.setInputFormat(data);
        Instances data1 = Filter.useFilter(data, Nominalize);        
        //System.out.println("\n" + data1 + "\n");        

        // save ARFF
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data1);
        saver.setFile(new File(arquivo2));
        saver.writeBatch();
        
        System.out.print("\n FIM");
    }

}
