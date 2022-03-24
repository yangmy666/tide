import annotation.FruitColor;
import annotation.FruitName;
import annotation.FruitProvider;

/**
 * @author YangMingYang
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor= FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

}
