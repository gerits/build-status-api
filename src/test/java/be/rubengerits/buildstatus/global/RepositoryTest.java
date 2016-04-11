package be.rubengerits.buildstatus.global;

import be.rubengerits.buildstatus.api.global.BuildStatus;
import be.rubengerits.buildstatus.api.global.Repository;
import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.ParseException;

import static org.testng.Assert.assertEquals;

public class RepositoryTest {
    @DataProvider(name = "compareToTests")
    public Object[][] createData1() throws ParseException {
        Repository repository01 = createRepository(0, "test0", BuildStatus.STATUS_BUILDING, "2015-01-01 01:00");
        Repository repository02 = createRepository(0, "test0", BuildStatus.STATUS_PASSING, "2015-01-01 01:00");

        Repository repository03 = createRepository(0, "test1", BuildStatus.STATUS_PASSING, "2015-01-01 01:00");
        Repository repository04 = createRepository(0, "test1", BuildStatus.STATUS_PASSING, "2015-01-01 02:00");

        Repository repository05 = createRepository(0, "test2a", BuildStatus.STATUS_PASSING, "2015-01-01 01:00");
        Repository repository06 = createRepository(0, "test2b", BuildStatus.STATUS_PASSING, "2015-01-01 01:00");

        Repository repository07 = createRepository(1, "test3", BuildStatus.STATUS_PASSING, "2015-01-01 01:00");
        Repository repository08 = createRepository(2, "test3", BuildStatus.STATUS_PASSING, "2015-01-01 01:00");

        return new Object[][]{
                {repository01, repository02, -1},
                {repository02, repository01, 1},
                {repository01, repository01, 0},

                {repository03, repository04, 1},
                {repository04, repository03, -1},
                {repository03, repository03, 0},

                {repository05, repository06, -1},
                {repository06, repository05, 1},
                {repository05, repository05, 0},

                {repository07, repository08, -1},
                {repository08, repository07, 1},
                {repository07, repository07, 0}
        };
    }

    private Repository createRepository(int id, String name, BuildStatus lastBuildStatus, String lastBuildFinishedAt) throws ParseException {
        Repository repository = new Repository();
        repository.setId(id);
        repository.setName(name);
        repository.setLastBuildStatus(lastBuildStatus);
        repository.setLastBuildFinishedAt(DateUtils.parseDate(lastBuildFinishedAt, "yyyy-MM-dd HH:mm"));
        return repository;
    }

    @Test(dataProvider = "compareToTests")
    public void testCompareTo(Repository repo1, Repository repo2, int expected) throws Exception {
        int result = repo1.compareTo(repo2);

        assertEquals(expected, result);
    }

}