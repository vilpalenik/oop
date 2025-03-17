

/** Vypracoval: Viliam Páleník
 * Java verzia:
    java version "19.0.2" 2023-01-17
    Java(TM) SE Runtime Environment (build 19.0.2+7-44)
    Java HotSpot(TM) 64-Bit Server VM (build 19.0.2+7-44, mixed mode, sharing)
 * Vývojové prostredie:
    Visual Studio Code  
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{6, -4, 2, -8, 6};
        System.out.println("Skalarny sucin vektorov a a b je: " + VectorUtils.dotProduct(a, b));
    }
}
