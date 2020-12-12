package entities.Countries;


interface CountryStrategy {
    public void initializeGenerals(General[] generals);
    public void initializeLeaders(Leader[] leaders);

}

class GermanyStrategy implements CountryStrategy{

    public void initializeGenerals(General[] generals){
        General Manstein = new General("Erich von Manstein", new float[]{0,0,0,0}, new float[]{-2,-2,-2,-2}, 4, null , 0, 0);
        General Rommel = new General("Erwin Rommel", new float[]{1,1,1,1}, new float[]{1,1,1,1}, 0, "Soviet Union", -4, -4);
        General Bock = new General("Fedor von Bock",new float[]{0,2,-1,0}, new float[]{0,2,-1,0}, 0,null, 0,0 );
        General inUseForBattle;
        generals = new General[]{Manstein, Rommel, Bock};
    }

    public void initializeLeaders(Leader[] leaders){
        Leader Hitler = new Leader("Adolf Hitler", "Fascist", -5, 3, 4, 4, new int[]{0, 1, 2, 3});
        Leader Wilhelm = new Leader("Wilhelm II", "Emperor", 2, 2, 4, 4 , new int[]{0, 1, 2, 3});
        Leader inUse;
        leaders = new Leader[]{Hitler, Wilhelm};
    }
}
