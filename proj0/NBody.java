public class NBody{


    public static double readRadius(String path){
		In in = new In(path);
		double number_of_planets = in.readInt();
		double Radius = in.readDouble();
        return Radius;
	}
    public static Planet[] readPlanets(String path){
    	In in = new In(path);
    	int num=in.readInt();
    	in.readDouble();
    	Planet[] AllPlanets= new Planet[num];
    	int i=0;
    	while (i<num){
    	    double xxPos=in.readDouble();
	        double yyPos=in.readDouble();
            double xxVel=in.readDouble();
            double yyVel=in.readDouble();
            double mass=in.readDouble();
            String imgFileName=in.readString();
            AllPlanets[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            i=i+1;
    	}
     return AllPlanets;
    }	
    public static void main(String[] args) {
        double T= Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double Radius=readRadius(filename);
        Planet[] AllPlanets=readPlanets(filename);
        

        String imageToDraw = "./images/starfield.jpg";
        //把planets的文件录入
        In in = new In(filename);
        double number_of_planets = in.readInt();
       

        StdDraw.enableDoubleBuffering();
        for(double TT=0;TT<T;TT=TT+dt){
           double[] xForces=new double[5];
           double[] yForces=new double[5];
            for(int i=0;i<number_of_planets;i++){
                xForces[i]=AllPlanets[i].calcNetForceExertedByX(AllPlanets);
                yForces[i]=AllPlanets[i].calcNetForceExertedByY(AllPlanets);
            }
             for(int i=0;i<number_of_planets;i++){
               AllPlanets[i].update(dt,xForces[i],yForces[i]);
               }
             StdDraw.setScale(-2*Radius,2*Radius);
             StdDraw.clear();
             StdDraw.picture(0,0,imageToDraw);
        

             for(int i=0;i<number_of_planets;i++){
             StdDraw.picture(AllPlanets[i].xxPos,AllPlanets[i].yyPos,"./images/"+AllPlanets[i].imgFileName);
             }

             StdDraw.show();
             StdDraw.pause(10);

        }
        /*print out results*/
        StdOut.printf("%d\n", planets.length);
        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

        

    }

}