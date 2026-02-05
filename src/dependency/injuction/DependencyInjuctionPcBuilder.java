package dependency.injuction;

class Processor {//also tries with void company(){print" " } without constructor and void info methord
    String company;

    Processor(String company){
        this.company=company;
    }
    void info(){
        System.out.println("company name of processor ="+company);
    }
}

class Ram{
    int size;
    Ram(int size){
        this.size=size;
    }
    void info(){
        System.out.println("size of ram ="+size+"GB");
    }
}

class Storage{
     int ssd;
     Storage(int ssd){
         this.ssd=ssd;
     }
     void info(){
         System.out.println("ssd TB is = "+ssd);
     }
}


class Computer{
     Processor processor;
     Ram ram;
     Storage storage;

    Computer(Processor processor, Ram ram, Storage storage){
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    void start(){ // if tried in that different way here ram.info will be ram.size()
            processor.info();
            ram.info();
            storage.info();
    }
}

public class DependencyInjuctionPcBuilder {
    public static void main(String[] args) {
        Processor p = new Processor("AMD");// here inside as there is no input beeing given "amd" will not be there
        Ram r = new Ram(16);
        Storage s = new Storage(2);

        Computer computer = new Computer(p,r,s);

        computer.start();
    }

}
