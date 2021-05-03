/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author anapat
 */
public class Fault {
    int no;
    String faultName;
    String typeOfFault;
    String fault_Length;
    
    public Fault(int no,String faultName,String typeOfFault,String fault_Length){
        this.no = no;
        this.faultName = faultName;
        this.typeOfFault = typeOfFault;
        this.fault_Length = fault_Length;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getTypeOfFault() {
        return typeOfFault;
    }

    public void setTypeOfFault(String typeOfFault) {
        this.typeOfFault = typeOfFault;
    }

    public String getFault_Length() {
        return fault_Length;
    }

    public void setFault_Length(String fault_Length) {
        this.fault_Length = fault_Length;
    }

}
