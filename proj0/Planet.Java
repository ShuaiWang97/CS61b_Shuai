public class Planet{
    public double xxPos;
	public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
	
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
    xxPos=xP;
    yyPos=yP;
    xxVel=xV;
    yyVel=yV;
    mass=m;
    imgFileName=img;

	}
    public Planet(Planet P){
      xxPos=P.xxPos;
      this.yyPos=P.yyPos;
      this.xxVel=P.xxVel;
      this.yyVel=P.yyVel;
      this.mass=P.mass;
      this.imgFileName=P.imgFileName;
    
    }
    public double calcDistance(Planet P){
    	//this should be a static function
         double delta_x,delta_y,dis;
         delta_x=this.xxPos-P.xxPos;
         delta_y=this.yyPos-P.yyPos;
         dis=java.lang.Math.sqrt(delta_x*delta_x+delta_y*delta_y);
         return dis;
    }
    public double calcForceExertedBy( Planet P){
             double force;
             double G= 6.67e-11;
             force=G*P.mass*this.mass/(this.calcDistance(P)*this.calcDistance(P));
             return force;
    }
    public double calcForceExertedByX( Planet P){
    	double force_x;
    	force_x=this.calcForceExertedBy(P)*(P.xxPos-this.xxPos)/this.calcDistance(P);
        return force_x;
    }

    public double calcForceExertedByY( Planet P){
    	double force_y;
        force_y=this.calcForceExertedBy(P)*(P.yyPos-this.yyPos)/this.calcDistance(P);
        return force_y;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
         double force_xx=0;
         for (int i=0;i<allPlanets.length;i++){
         	if (allPlanets[i].equals(this)){
         		continue;
         	}
         	force_xx=this.calcForceExertedByX(allPlanets[i])+force_xx;
         }
         return force_xx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
         double force_yy=0;
         for (int i=0;i<allPlanets.length;i++){
         	if (allPlanets[i].equals(this)){
         		continue;
         	}
         	force_yy=this.calcForceExertedByY(allPlanets[i])+force_yy;
         }
         return force_yy;
    }   
    
    public void update (double dt, double fX, double fY){
    	double ax,ay;
    	ax=fX/this.mass;
    	ay=fY/this.mass;
    	this.xxVel=this.xxVel+ax*dt;
    	this.yyVel=this.yyVel+ay*dt;
    	this.xxPos=this.xxPos+this.xxVel*dt;
    	this.yyPos=this.yyPos+this.yyVel*dt;
    }

   }   
 
