# ELAINE CECILIA GATTO
# 2020-04-16
# R MULTILABEL CSV TO ARFF

sistema = c(Sys.info())
if (sistema[1] == "Linux"){
  Folder = paste("/home/", sistema[7], "/R_MultiLabel_Csv2Arff", sep="")
  setwd(Folder)
} else {
  Folder = paste("C:/Users/", sistema[7], "/R_MultiLabel_Csv2Arff", sep="")
  setwd(Folder)
}

arg1 = " flags-Split-Tr-5.csv "
arg2 = " flags-Split-Tr-5.arff "
arg3 = " 21-27 "

str = paste("java -jar ", Folder, "/R_csv_2_arff.jar ", arg1, " ", arg2, " ", arg3, sep="")
system(str)
