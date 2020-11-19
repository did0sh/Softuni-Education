package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.Assert.*;

public class MissionControlImplTest {

    private MissionControl missionControl;
    private Mission mission;

    @Before
    public void setUp() throws Exception {
        this.missionControl = new MissionControlImpl();
        this.mission = Mockito.mock(Mission.class);
    }

    @Test
    public void generateMissionWithValidArguments() {
            Mockito.when(this.mission.getId()).thenReturn("DDDDDD");
            Mockito.when(this.mission.getRating()).thenReturn(50.0);
            Mockito.when(this.mission.getBounty()).thenReturn(5.0);

            Mission mission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());

        Assert.assertEquals(50.0 * 0.75, mission.getRating(), 0.01);
        Assert.assertEquals(5.0 * 1.25, mission.getBounty(), 0.01);
        Assert.assertEquals(mission.getId(), "DDDDDD");
    }

    @Test
    public void generateMissionWithInValidArguments() {
        Mockito.when(this.mission.getId()).thenReturn("DDDDDDDDDDD");
        Mockito.when(this.mission.getRating()).thenReturn(300.0);
        Mockito.when(this.mission.getBounty()).thenReturn(-2.0);

        Mission mission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());

        Assert.assertEquals(100.0 * 0.75, mission.getRating(), 0.01);
        Assert.assertEquals(0.0, mission.getBounty(), 0.01);
        Assert.assertEquals(mission.getId(), "DDDDDDDD");
    }

    @Test
    public void changesTheTypeOfMission() {
        Mockito.when(this.mission.getId()).thenReturn("DDDDDDDDDDD");
        Mockito.when(this.mission.getRating()).thenReturn(300.0);
        Mockito.when(this.mission.getBounty()).thenReturn(2.0);

        Mission mission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());
        Mission huntMission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());

        Assert.assertEquals(100.0 * 1.50, huntMission.getRating(), 0.01);
        Assert.assertEquals(2.0 * 2, huntMission.getBounty(), 0.01);
        Assert.assertEquals(huntMission.getId(), "DDDDDDDD");
    }

    @Test
    public void changesTheTypeOfMissionTo3() {
        Mockito.when(this.mission.getId()).thenReturn("asd");
        Mockito.when(this.mission.getRating()).thenReturn(-10.0);
        Mockito.when(this.mission.getBounty()).thenReturn(100000000D);

        Mission mission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());
        Mission huntMission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());
        Mission survMission = this.missionControl.generateMission(this.mission.getId(), this.mission.getRating(), this.mission.getBounty());

        Assert.assertEquals(0.0, survMission.getRating(), 0.01);
        Assert.assertEquals(100000D * 1.50, survMission.getBounty(), 0.01);
        Assert.assertEquals(survMission.getId(), "asd");
    }


    @Test
    public void shouldHaveSizeOf3() throws NoSuchFieldException, IllegalAccessException {
        Field field = MissionControlImpl.class.getDeclaredField("missionClasses");
        field.setAccessible(true);
        Map<String, Mission> map = (Map<String, Mission>) field.get(this.missionControl);

        Assert.assertEquals(3, map.size());
    }
}