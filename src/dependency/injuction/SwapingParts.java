package dependency.injuction;

class ProcessingUnit {//also tries with void company(){print" " } without constructor and void info methord
    String manufacture;

    ProcessingUnit(String manufactor){
        this.manufacture =manufactor;
    }
    void output(){
        System.out.println("processor company name (swap) ="+ manufacture);
    }
}

class RandomAccessMemory{
    int sizee;
    RandomAccessMemory(int sizee){
        this.sizee=sizee;
    }
    void output(){
        System.out.println("size of ram (swape) ="+sizee);
    }
}

class SystemStorage{
    int ssds;
    SystemStorage(int ssds){
        this.ssds=ssds;
    }
    void output(){
        System.out.println("ssd TB is(swap) = "+ssds);
    }
}


class Computers{
    ProcessingUnit processingunit;
    RandomAccessMemory randomaccessmemory;
    SystemStorage systemstorage;

    Computers(ProcessingUnit processingunit, RandomAccessMemory randomaccessmemory, SystemStorage systemstorage){
        this.processingunit = processingunit;
        this.randomaccessmemory = randomaccessmemory;
        this.systemstorage = systemstorage;
    }
    void updateram(RandomAccessMemory randomaccessmemory){
        this.randomaccessmemory=randomaccessmemory;
    }

    void starting(){ // if tried in that different way here ram.info will be ram.size()
        processingunit.output();
        randomaccessmemory.output();
        systemstorage.output();
    }
}

public class SwapingParts {
    public static void main(String[] args) {
        ProcessingUnit proc = new ProcessingUnit("intel");// here inside as there is no input beeing given "amd" will not be there
        RandomAccessMemory ramm = new RandomAccessMemory(32);
        SystemStorage stor = new SystemStorage(5);

        Computers computer = new Computers(proc,ramm,stor);

        computer.starting();
        computer.updateram(new RandomAccessMemory(64));
        computer.starting();
    }

}
