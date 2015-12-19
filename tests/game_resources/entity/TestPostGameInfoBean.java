package game_resources.entity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPostGameInfoBean {

    PostGameInfoBean postGameInfoBean;

    @Test
    public void testInstantiatePostGameInfoBeanWithoutParameters() {
        postGameInfoBean = new PostGameInfoBean();
        assertNotNull(postGameInfoBean);
    }

    @Test
    public void testInstantiatePostGameInfoBeanWithParameters() {
        postGameInfoBean = new PostGameInfoBean(null, null, 0);
        assertNotNull(postGameInfoBean);
    }

    @Test
    public void testPostGameInfoBeanToString() {
        Integer[] integerArray = new Integer[0];
        postGameInfoBean = new PostGameInfoBean(integerArray, "", 0);
        String actualString = postGameInfoBean.toString();
        String expectedString = "gameSessionArray size: 0; username: ; listId: 0";
        assertEquals("Testing the 'PostGameInfoBean' toString() method.", expectedString, actualString);
    }

}
