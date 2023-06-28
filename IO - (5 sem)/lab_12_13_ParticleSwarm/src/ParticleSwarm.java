public class ParticleSwarm {
    public static double sphere(double[] X) {
        double sum = 0;
        for(int i=0; i<X.length; i++)
            sum += Math.pow(X[i],2);
        return sum;
    }
    public static double ackley(double[] X) {
        double a = 20;
        double b = 0.2;
        double c = 2*Math.PI;
        double sum = 0;
        double sumPart = 0;
        for(int i=0; i<X.length; i++)
            sumPart += Math.pow(X[i],2);
        sum -= a*Math.exp(-b*Math.sqrt((1d/X.length)*sumPart));
        sumPart = 0;
        for(int i=0; i<X.length; i++)
            sumPart += Math.cos(c*X[i]);
        sum -= Math.exp((1d/X.length)*sumPart);
        sum += a+Math.E;
        return sum;
    }
    public static double griewank(double[] X) {
        double sum = 0;
        double prod = 1;
        for(int i=0; i<X.length; i++)
            sum += Math.pow(X[i],2)/4000;
        for(int i=0; i<X.length; i++)
            prod *= Math.cos(X[i]/Math.sqrt(X[i]));
        sum += 1;
        return sum;
    }
    public static double rastrigin(double[] X) {
        double sum = 10*X.length;
        for(int i=0; i<X.length; i++)
            sum += Math.pow(X[i],2)-10*Math.cos(2*Math.PI*X[i]);
        return sum;
    }
    public static double rosenbrock(double[] X) {
        double res = 0;
        for(int i=0; i<X.length-1; i++)
            res += 100*Math.pow(X[i+1]-Math.pow(X[i],2),2)+Math.pow(1-X[i],2);
        return res;
    }


    public static double[] particleSwarmOptimization(int n, int MAX_ITER, double fi1, double fi2, ParticleSwarmFunction psf,
                                                   int d, double x1, double x2) {
        double[][] x = new double[n][d];
        double[][] v = new double[n][d];
        double[] y = new double[n];
        double[][] p = new double[n][d];
        double[] pbest = new double[n];
        double[][] g = new double[n][d];
        double[] gbest = new double[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<d; j++) {
                x[i][j] = (x2-x1)*Math.random()+x1;
                v[i][j] = 0;
                p[i][j] = x[i][j];
                g[i][j] = x[i][j];
            }
            y[i] = psf.objFunction(x[i]);
            pbest[i] = y[i];
            gbest[i] = y[i];
        }

        for(int k=0; k<MAX_ITER; k++) {

            for(int i=0; i<n; i++) {
                y[i] = psf.objFunction(x[i]);

                if(y[i]<pbest[i]) {
                    pbest[i] = y[i];
                    for(int j=0; j<d; j++)
                        p[i][j] = x[i][j];
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(y[i]<y[j]) {
                        gbest[i] = y[i];
                        for(int l=0; l<d; l++)
                            g[i][l] = x[j][l];
                    }
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<d; j++) {
                    v[i][j] += fi1*Math.random()*(p[i][j]-x[i][j])+fi2*Math.random()*(g[i][j]-x[i][j]);

                    if(x[i][j]+v[i][j]>=x1 && x[i][j]+v[i][j]<=x2)
                        x[i][j] += v[i][j];
                }
            }
        }

        double best = Double.MAX_VALUE;
        double[] bestVector = p[0];
        for(int i=0; i<pbest.length; i++) {
            //System.out.println(gbest[i]);
            if(pbest[i]<best) {
                best = pbest[i];
                for(int j=0;j<d;j++) {
                    bestVector[j] = p[i][j];
                }
            }
        }
        return bestVector;
    }

    public static void main(String[] args) {
        ParticleSwarmFunction psphere = new ParticleSwarmFunction() {
            @Override
            public double objFunction(double[] X) {
                return sphere(X);
            }
        };
        ParticleSwarmFunction packley = new ParticleSwarmFunction() {
            @Override
            public double objFunction(double[] X) {
                return ackley(X);
            }
        };
        ParticleSwarmFunction pgriewank = new ParticleSwarmFunction() {
            @Override
            public double objFunction(double[] X) {
                return griewank(X);
            }
        };
        ParticleSwarmFunction prastrigin = new ParticleSwarmFunction() {
            @Override
            public double objFunction(double[] X) {
                return rastrigin(X);
            }
        };
        ParticleSwarmFunction prosenbrock = new ParticleSwarmFunction() {
            @Override
            public double objFunction(double[] X) {
                return rosenbrock(X);
            }
        };

        double[] bestVector = particleSwarmOptimization(40, 100,0.2,0.2,psphere,2,-5.12,5.12);
        System.out.println("Best Sphere = "+psphere.objFunction(bestVector));
        bestVector = particleSwarmOptimization(40, 100,0.2,0.2,packley,2,-5.12,5.12);
        System.out.println("Best Ackley = "+psphere.objFunction(bestVector));
        bestVector = particleSwarmOptimization(40, 100,0.2,0.2,pgriewank,2,-5.12,5.12);
        System.out.println("Best Griewank = "+psphere.objFunction(bestVector));
        bestVector = particleSwarmOptimization(40, 100,0.2,0.2,prastrigin,2,-5.12,5.12);
        System.out.println("Best Rastrigin = "+psphere.objFunction(bestVector));
        bestVector = particleSwarmOptimization(40, 100,0.2,0.2,prosenbrock,2,-5.12,5.12);
        System.out.println("Best Rosenbrock = "+psphere.objFunction(bestVector));
    }
}
