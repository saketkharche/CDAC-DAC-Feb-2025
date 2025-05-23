class switch1{
    boolean sw=false;
    
    static void SwitchOn(boolean sw){

    }
    static void SwitchOff(boolean sw){
    }

    static void check(boolean sw){
        if(sw==true){
            System.out.println("Bulb Is On");
        }else{
            System.out.println("Bulb is off");
        }
    }

}

class LightBulb {
    public static void main(String[] args) {
        switch1 s=new switch1();
        s.SwitchOn();
        s.check();
        s.SwitchOff();
        s.check();

    }

    
}
