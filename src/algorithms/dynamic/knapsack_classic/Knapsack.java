package algorithms.dynamic.knapsack_classic;

public class Knapsack {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // W ограничение по весу рюкзаке
        // wt массив с весом предметов
        // val стоимость предметов
        // количество предметов
        int i, w;// i номер предмета в массиве. w номер в массиве веса каждого элемента.
        /*Допустим у нас есть
        * массив вещей с массой и стоимостью каждой
        * 5 кг и 60 долларов  3кг и 50 долларов  4кг и 70 долларов  3кг и 30 долларов
        *
        * */
        int [][]K = new int[n+1][W+1];

        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)//первая линия по горизонтали заполняется нулями потому что если не брать ни одного предмета то стоимость тоже равна 0
                    K[i][w] = 0;//первая линия по вертикали заполняется нулями потому что стоимость всегда равна нулю при нулевой вместимости рюкзака
                else if (wt[i-1] <= w)//если масса текущей вещи ниже массы рюкзака
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);//выбираем максимум из двух вариантов
                //1 мы включаем его в рюкзак увеличиваем стоимость рюкзака на стоимость вещи и тогда нам надо взять максимум для массы без этой вещи
                //2 или не включаем его и берем максимальную стоимость рюкзака для данной массы без этого предмета
                else
                    K[i][w] = K[i-1][w];//если масса данного предмета больше массы рюкзака с текущей вместимостью то мы присваиваем предыдущий максимум без данной вещи
            }
        }

        return K[n][W];
    }
}
