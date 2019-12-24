package Encapsulatedbehaviors;
import java.util.Map;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
public interface SearchingBehavior {
     public  Map<product, store>searchingAboutMatchingProduct(String location,String searchp,int counter ); 
     
}
