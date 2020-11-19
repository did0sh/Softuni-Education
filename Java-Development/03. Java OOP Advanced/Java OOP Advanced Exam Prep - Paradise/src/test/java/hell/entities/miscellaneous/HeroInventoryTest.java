package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

public class HeroInventoryTest {
    private Item item;
    private Item otherItem;
    private Recipe recipe;
    private Recipe otherRecipe;

    private HeroInventory heroInventory;

    @Before
    public void setUp() throws Exception {
        this.heroInventory = new HeroInventory();

        this.item = Mockito.mock(Item.class);
        this.otherItem = Mockito.mock(Item.class);
        this.recipe = Mockito.mock(Recipe.class);
        this.otherRecipe = Mockito.mock(Recipe.class);
    }

    @Test
    public void getTotalStrengthBonus() {
        Mockito.when(this.item.getName()).thenReturn("item1");
        Mockito.when(this.otherItem.getName()).thenReturn("item2");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(otherItem);

        Mockito.when(this.item.getStrengthBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.otherItem.getStrengthBonus()).thenReturn(2_000_000_000);

        long expected = 4_000_000_000L;
        long actual = this.heroInventory.getTotalStrengthBonus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalAgilityBonus() {
        Mockito.when(this.item.getName()).thenReturn("item1");
        Mockito.when(this.otherItem.getName()).thenReturn("item2");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(otherItem);

        Mockito.when(this.item.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.otherItem.getAgilityBonus()).thenReturn(2_000_000_000);

        long expected = 4_000_000_000L;
        long actual = this.heroInventory.getTotalAgilityBonus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        Mockito.when(this.item.getName()).thenReturn("item1");
        Mockito.when(this.otherItem.getName()).thenReturn("item2");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(otherItem);

        Mockito.when(this.item.getIntelligenceBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.otherItem.getIntelligenceBonus()).thenReturn(2_000_000_000);

        long expected = 4_000_000_000L;
        long actual = this.heroInventory.getTotalIntelligenceBonus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalHitPointsBonus() {
        Mockito.when(this.item.getName()).thenReturn("item1");
        Mockito.when(this.otherItem.getName()).thenReturn("item2");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(otherItem);

        Mockito.when(this.item.getHitPointsBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.otherItem.getHitPointsBonus()).thenReturn(2_000_000_000);

        long expected = 4_000_000_000L;
        long actual = this.heroInventory.getTotalHitPointsBonus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalDamageBonus() {
        Mockito.when(this.item.getName()).thenReturn("item1");
        Mockito.when(this.otherItem.getName()).thenReturn("item2");

        this.heroInventory.addCommonItem(item);
        this.heroInventory.addCommonItem(otherItem);

        Mockito.when(this.item.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.otherItem.getDamageBonus()).thenReturn(Integer.MAX_VALUE);

        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;
        long actual = this.heroInventory.getTotalDamageBonus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveDefaultZeroValue() {
        long expected = 0;
        long actual = this.heroInventory.getTotalDamageBonus();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void emptyCollectionShouldReturnZero() {
        Assert.assertEquals(0, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalDamageBonus());
    }

    @Test(expected = NullPointerException.class)
    public void addNullItemShouldThrowException() {
        this.heroInventory.addCommonItem(null);
    }

    @Test(expected = NullPointerException.class)
    public void addNullRecipeShouldThrowException() {
        this.heroInventory.addRecipeItem(null);
    }

    @Test
    public void instantiatingInventoryShouldNotThrowException() {
        Inventory inventory = new HeroInventory();
    }

    @Test
    public void addingTheSameCommonItemTwiceShouldNotIncreaseCollectionSize() throws NoSuchFieldException, IllegalAccessException {
        this.heroInventory.addCommonItem(this.item);
        this.heroInventory.addCommonItem(this.item);

        Mockito.when(this.item.getDamageBonus()).thenReturn(Integer.MAX_VALUE);

        Field field = this.heroInventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.heroInventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
        Assert.assertEquals(Integer.MAX_VALUE, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void addingNewCommonShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException {
        this.heroInventory.addRecipeItem(this.recipe);
        Field field = this.heroInventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.heroInventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void collectionSizeShouldBeZeroAfterInstantiation() throws NoSuchFieldException, IllegalAccessException {
        Field commonItems = this.heroInventory.getClass().getDeclaredField("commonItems");
        commonItems.setAccessible(true);
        Map<String, Item> commonMap = (Map<String, Item>) commonItems.get(this.heroInventory);
        Field recipeItems = this.heroInventory.getClass().getDeclaredField("recipeItems");
        recipeItems.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) recipeItems.get(this.heroInventory);
        Assert.assertEquals("Incorrect items count", 0, commonMap.size());
        Assert.assertEquals("Incorrect items count", 0, recipeMap.size());
    }

    @Test
    public void addingElementShouldGetTheSameElementFromCollection() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.item.getName()).thenReturn("Gosho");

        this.heroInventory.addCommonItem(this.item);
        Field field = this.heroInventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.heroInventory);
        Assert.assertSame(this.item, recipeMap.get(this.item.getName()));
    }

    @Test
    public void addingRecipeShouldGetTheSameElementFromCollection() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.recipe.getName()).thenReturn("Gosho");

        this.heroInventory.addRecipeItem(this.recipe);
        Field field = this.heroInventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.heroInventory);
        Assert.assertSame(this.recipe, recipeMap.get(this.recipe.getName()));
    }

    @Test
    public void addingRecipeShouldNotIncreaseStats() {
        this.heroInventory.addRecipeItem(this.recipe);
        Assert.assertEquals(0, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(0, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void addingItemShouldGiveAllCorrectResults() {
        Mockito.when(this.item.getStrengthBonus()).thenReturn(10);
        Mockito.when(this.item.getAgilityBonus()).thenReturn(20);
        Mockito.when(this.item.getIntelligenceBonus()).thenReturn(30);
        Mockito.when(this.item.getHitPointsBonus()).thenReturn(40);
        Mockito.when(this.item.getDamageBonus()).thenReturn(50);

        this.heroInventory.addCommonItem(this.item);

        Assert.assertEquals(10, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(20, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(30, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(40, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(50, this.heroInventory.getTotalDamageBonus());
    }
}