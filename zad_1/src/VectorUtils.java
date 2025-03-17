public class VectorUtils {

    /**
     * Fukcia vypocita skalarny sucin vektorov a a b.
     * Z definicie skalarneho sucinu vyplyva, ze vektory a a b musia mat rovnaku dlzku.
     *
     * @param a pole reprezentujuce vektor, nesmie byt null.
     * @param b pole reprezentujuce vektor, nesmie byt null.
     * @return null ak doslo k chybe, alebo su nevhodne parametre. Inak vrati spocitany skalarny sucin.
     */
    public static Integer dotProduct(int[] a, int[] b) {
        // najpr kontrola aby vektory neboli null/ nemali dlzku 0, alebo rozne dlzky.
        // potom scitam a0*b0 + a1*b1 + ... + ai*bi
        if (a==null || b==null) return (null);

        if (a.length == 0 || b.length == 0) return (null);
        
        if (a.length != b.length) return (null);

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i]*b[i];
        }
        return sum;
    }
}
