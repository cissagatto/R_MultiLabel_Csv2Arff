# R_MultiLabel_Csv2Arff


## Execute

argument 1: string csv file name with its respective folder path

argument 2: string arff file name with its respective folder path (no problem, the file does not exist! it will be created here)

argument 3: range of labels that will be converted to nominal

### Terminal
*java -jar R_csv_2_arff.jar "arg1" "arg2" "arg3"*

### R Example
sistema = c(Sys.info())
if (sistema[1] == "Linux"){
  Folder = paste("/home/", sistema[7], "/R_MultiLabel_Csv2Arff", sep="")
  setwd(Folder)
} else {
  Folder = paste("C:/Users/", sistema[7], "/R_MultiLabel_Csv2Arff", sep="")
  setwd(Folder)
}
setwd(Folder)

arg1 = "flags-Split-Tr-5.csv"
arg2 = "flags-Split-Tr-5.arff"
arg3 = "21-27"

str = paste("java -jar ", FolderRoot, "R_csv_2_arff.jar ", arg1, " ", arg2, " ", arg3, sep="")
system(str)
