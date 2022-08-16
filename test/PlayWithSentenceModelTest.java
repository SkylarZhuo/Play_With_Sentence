import model.PlayWithSentenceModel;
import model.PlayWithSentenceModelImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * The unit test class for PlayWithSentenceModelImpl
 */
public class PlayWithSentenceModelTest {

    PlayWithSentenceModel model1 = new PlayWithSentenceModelImpl("We are having pizza in the evening!");
    PlayWithSentenceModel model2 = new PlayWithSentenceModelImpl("I am eating brunch now, would you like to come with me tomorrow?");
    PlayWithSentenceModel model3 = new PlayWithSentenceModelImpl("I like butterflyy and watermelon, what about you?");
    PlayWithSentenceModel model4 = new PlayWithSentenceModelImpl("Emily eats eggs");
    PlayWithSentenceModel model5 = new PlayWithSentenceModelImpl("How are you!");

    /**
     * Test the countWord() method for four model object
     */
    @Test
    public void testCoundWord(){
        assertEquals(7,model1.countWord());
        assertEquals(13,model2.countWord());
        assertEquals(8,model3.countWord());
        assertEquals(3,model4.countWord());
        assertEquals(3,model5.countWord());
    }

    /**
     * Test the getLongestWord() method for four model object
     */
    @Test
    public void testLongestWord(){
        assertEquals("evening",model1.getLongestWord());
        assertEquals("tomorrow",model2.getLongestWord());
        assertEquals("butterflyy & watermelon",model3.getLongestWord());
        assertEquals("emily",model4.getLongestWord());
        assertEquals("how & are & you",model5.getLongestWord());

    }

    /**
     * test getPopularLetter() for four model object
     */
    @Test
    public void testGetPopularLetter(){
        PlayWithSentenceModel m = new PlayWithSentenceModelImpl("I love you eusan");
        assertEquals("e",model1.getPopularLetter());
        assertEquals("o",model2.getPopularLetter());
        assertEquals("t",model3.getPopularLetter());
        assertEquals("e",model4.getPopularLetter());
        assertEquals("e & u & o",m.getPopularLetter());
    }

    /**
     * Test the countWord() method
     */
    @Test
    public void testTransformPigLatin(){
        PlayWithSentenceModel m1 = new PlayWithSentenceModelImpl();
        assertEquals("igpay atinlay ananabay ilesmay eatyay omeletyay! ",m1.transformPigLatin("pig latin banana smile eat omelet!"));
        assertEquals("owhay areyay ouyay! ",m1.transformPigLatin("how are you!"));
        assertEquals("emilyyay eatsyay eggsyay ",m1.transformPigLatin("Emily eats eggs"));
        assertEquals("iyay amyay eatingyay unchbray ownay, ouldway ouyay ikelay otay omecay ithway emay omorrowtay? ",m1.transformPigLatin("I am eating brunch now, would you like to come with me tomorrow?"));
        assertEquals("iyay ikelay utterflyybay andyay atermelonway, atwhay aboutyay ouyay? ",m1.transformPigLatin("I like butterflyy and watermelon, what about you?"));
    }

    /**
     * Test toString() method
     */
    @Test
    public void testToString(){
        assertEquals("we are having pizza in the evening ",model1.toString());
        assertEquals("i am eating brunch now  would you like to come with me tomorrow ",model2.toString());
        assertEquals("i like butterflyy and watermelon  what about you ",model3.toString());
        assertEquals("emily eats eggs",model4.toString());
    }
}
