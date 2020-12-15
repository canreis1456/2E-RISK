package entities;


import java.util.List;

interface CountryInitializer {
    void initializeGenerals(List<General> generals);
    void initializeLeaders(List<Leader> leaders);

}

class GermanyInitializer implements CountryInitializer{

    public void initializeGenerals(List<General> generals){
        General Manstein = new General("Erich von Manstein", new float[]{0,0,0,0}, new float[]{-2,-2,-2,-2}, 4, null , 0, 0);
        General Rommel = new General("Erwin Rommel", new float[]{1,1,1,1}, new float[]{1,1,1,1}, 0, "Soviet Union", -4, -4);
        General Bock = new General("Fedor von Bock",new float[]{0,2,-1,0}, new float[]{0,2,-1,0}, 0,null, 0,0 );
        generals.add(Manstein);
        generals.add(Rommel);
        generals.add(Bock);
    }

    public void initializeLeaders(List<Leader> leaders){
        Leader Hitler = new Leader("Adolf Hitler", "Fascist", -5, 3, 4, 4, new int[]{0, 1, 2, 3});
        Leader Wilhelm = new Leader("Wilhelm II", "Emperor", 2, 2, 4, 4 , new int[]{0, 1, 2, 3});
        leaders.add(Hitler);
        leaders.add(Wilhelm);
    }
}

class SovietInitializer implements CountryInitializer{
    public void initializeGenerals(List<General> generals){
        General Zhukov = new General("Georgy Zhukov", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 4, "German Reich" , 2, 0);
        General Tukhachevsky = new General("Mikhail Tukhachevsky", new float[]{1,1,1,1}, new float[]{1,1,1,1}, 0, null, 0, 0);
        General Rokossovsky = new General("Konstantin Rokossovsky",new float[]{0,0,3,0}, new float[]{0,0,3,0}, 0,null, 0,0 );
        generals.add(Zhukov);
        generals.add(Tukhachevsky);
        generals.add(Rokossovsky);
    }

    public void initializeLeaders(List<Leader> leaders){
        Leader Stalin = new Leader("Joseph Stalin", "Communism", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
        Leader Trotsky = new Leader("Leon Trotsky", "Communism", 0, 0, 4, 4 , new int[]{0, 1, 2, 3});
        leaders.add(Stalin);
        leaders.add(Trotsky);
    }

}
class FranceInitializer implements CountryInitializer {
    public void initializeGenerals(List<General> generals) {
        General Tassigny = new General("Jean de Lattre de Tassigny", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 4, "German Reich" , 0, 3);
        General Georges = new General("Alphonse Georges", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 0, "German Reich", 3, 0);
        generals.add(Tassigny);
        generals.add(Georges);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader Charles = new Leader("Charles de Gaulle", "Democrat", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
        Leader Philippe = new Leader("Philippe Pétain", "Fascist", 0, 0, 4, 4 , new int[]{0, 1, 2, 3});
        leaders.add(Charles);
        leaders.add(Philippe);
    }
}

class ChinaInitializer implements CountryInitializer {
    public void initializeGenerals(List<General> generals) {
        General Jen = new General("Sun Li Jen", new float[]{0,0,0,0}, new float[]{4,4,4,4}, 4, null , 0, 0);
        General Zongnan = new General("Hu Zongnan", new float[]{4,4,4,4}, new float[]{0,0,0,0}, 0, null, 0, 0);
        generals.add(Jen);
        generals.add(Zongnan);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader Kaishek = new Leader("Chiang Kai-shek", "Non-Aligned", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
        leaders.add(Kaishek);
    }
}

class ItalyInitializer implements CountryInitializer{

    public void initializeGenerals(List<General> generals) {
        General Cavallero = new General("Ugo Cavallero", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 4, "France" , 0, 2);
        General Messe = new General("Giovanni Messe", new float[]{0,0,2,0}, new float[]{0,0,2,0}, 0, "Soviet Union", -1, 0);
        generals.add(Cavallero);
        generals.add(Messe);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader Mussolini = new Leader("Benito Mussolini", "Fascist", -2, 0, 4, 4, new int[]{0, 1, 2, 3}); // 2.5 desteklenmiyo kkn
        Leader Parri = new Leader("Ferruco Parri", "Democrat", 0, 0, 4, 4 , new int[]{0, 1, 2, 3});
        leaders.add(Mussolini);
        leaders.add(Parri);
    }
}

class USAInitializer implements CountryInitializer {

    public void initializeGenerals(List<General> generals) {
        General MacArthur = new General("Douglas MacArthur", new float[]{-3, -3, -3, -3}, new float[]{3, 3, 3, 3}, 4, null, 0, 0);
        General Patton = new General("George S. Patton", new float[]{0, -1, 2, 0}, new float[]{0, -1, 2, 0}, 0, null, 0, 0);
        General Eisenhower = new General("Dwight D. Eisenhower", new float[]{0, 0, 0, 0}, new float[]{0, 0, 0, 0}, 0, null, 0, 0);
        generals.add(MacArthur);
        generals.add(Patton);
        generals.add(Eisenhower);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader Rosewelt = new Leader("Franklin Delano Roosevelt", "Democrat", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
        Leader London = new Leader("Alf London", "Republican", 0, 0, 4, 4 , new int[]{0, 1, 2, 3});
        leaders.add(Rosewelt);
        leaders.add(London);
    }
}

class JapanInitializer implements CountryInitializer{

    public void initializeGenerals(List<General> generals) {
        General Yamashita = new General("Tomoyuki Yamashita", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 4, "Soviet Union" , -3, 0);
        General Terauchi = new General("Hisaichi Terauchi", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 0, "China", 0, 2);
        generals.add(Yamashita);
        generals.add(Terauchi);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader Hirohito = new Leader("Hirohito", "Fascist", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
        leaders.add(Hirohito);
    }
}

class TurkeyInitializer implements CountryInitializer{

    public void initializeGenerals(List<General> generals) {
        General Cakmak = new General("Fevzi Cakmak", new float[]{1,1,1,1}, new float[]{1,1,1,1}, 4, null , 0, 0);
        General Karabekir = new General("Kazım Karabekir", new float[]{2,2,2,2}, new float[]{0,0,0,0}, 0, null, 0, 0);
        General Altay = new General("Fahrettin Altay", new float[]{0,0,0,0}, new float[]{0,0,0,0}, 0, null, 0, 0);
        generals.add(Cakmak);
        generals.add(Karabekir);
        generals.add(Altay);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader IsmetInonu = new Leader("Ismet Inonu", "Authoritarian", 0, -1, 4, 4, new int[]{0, 1, 2, 3});
        Leader Abdulmejid = new Leader("Abdulmejid II", "Emperor", 0, 2, 4, 4 , new int[]{0, 1, 2, 3});
        leaders.add(IsmetInonu);
        leaders.add(Abdulmejid);
    }
}

class UKInitializer implements CountryInitializer {

    public void initializeGenerals(List<General> generals) {
        General Montgomery = new General("Bernard Montgomery", new float[]{0, 0, 0, 0}, new float[]{2, 2, 2, 2}, 4, null, 0, 0);
        General Brooke = new General("Alan Brooke", new float[]{0, 0, 0, 0}, new float[]{0, 0, 0, 0}, 0, "German Reich", 0, 3);
        generals.add(Montgomery);
        generals.add(Brooke);
    }

    public void initializeLeaders(List<Leader> leaders) {
        Leader Churchill = new Leader("Winston Churchill", "Democrat", -1, -1, 4, 1, new int[]{1});
        Leader Mosley = new Leader("Oswald Mosley", "Fascist", 0, 0, 4, 4, new int[]{0, 1, 2, 3});
        leaders.add(Churchill);
        leaders.add(Mosley);
    }
}