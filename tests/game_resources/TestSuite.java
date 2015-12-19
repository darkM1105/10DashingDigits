package game_resources;

import game_resources.entity.TestGameSession;
import game_resources.entity.TestPostGameInfoBean;
import game_resources.entity.TestPreGameInfoBean;
import game_resources.entity.TestWordList;
import game_resources.persistence.TestGameDAO;
import game_resources.persistence.TestSessionFactoryProvider;
import game_resources.processing.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestGameSession.class,
        TestWordList.class,
        TestPreGameInfoBean.class,
        TestPostGameInfoBean.class,
        TestSessionFactoryProvider.class,
        TestCompressor.class,
        TestDataTester.class,
        TestDecompressor.class,
        TestRandomizedData.class,
        TestRandomizedName.class,
        TestRandomizer.class,
        TestGameDAO.class
})
public class TestSuite {}