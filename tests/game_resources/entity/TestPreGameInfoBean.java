package game_resources.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPreGameInfoBean {

    PreGameInfoBean preGameInfoBean;

    @Test
    public void testInstantiatePreGameInfoBeanWithoutParameters() {
        preGameInfoBean = new PreGameInfoBean();
        assertNotNull(preGameInfoBean);
    }

    @Test
    public void testInstantiatePreGameInfoBeanWithParameters() {
        preGameInfoBean = new PreGameInfoBean(null, null, null, null, 0);
        assertNotNull(preGameInfoBean);
    }

    @Test
    public void testPreGameInfoBeanToString() {
        String[] stringArray = new String[0];
        Integer[] integerArray = new Integer[0];
        preGameInfoBean = new PreGameInfoBean(stringArray, integerArray, "", "", 0);
        String actualString = preGameInfoBean.toString();
        String expectedString = "wordListArray size: 0; gameSessionArray size: 0; username: ; opponentUsername: ; listId: 0";
        assertEquals("Testing the 'PreGameInfoBean' toString() method.", expectedString, actualString);
    }

}
