package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController mockController;
    private TrainUser mockUser;
    private TrainSensor trainSensor;

    @Before
    public void before() {
        // TODO Add initializations
        mockController = mock(TrainController.class);
        mockUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void setSpeedLimitTo501RaiseAlarm() {

        // Arrange
        when(mockController.getReferenceSpeed()).thenReturn(100);

        // Act
        trainSensor.overrideSpeedLimit(501);

        // Assert
        verify(mockUser, atLeastOnce()).setAlarmState(true);
    }

    @Test
    public void setSpeedLimitToLowerThan0RaiseAlarm() {
        //Arrange
        when(mockController.getReferenceSpeed()).thenReturn(100);
        // Act
        trainSensor.overrideSpeedLimit(-1);

        // Assert
        verify(mockUser, atLeastOnce()).setAlarmState(true);
    }

    @Test
    public void setSpeedLimitBetweenBoundaries() {

        // Arrange
        when(mockController.getReferenceSpeed()).thenReturn(100);

        // Act
        trainSensor.overrideSpeedLimit(200);

        // Assert
        verify(mockUser, never()).setAlarmState(true);
    }

    @Test
    public void setSpeedLimitViolateRelativeMarginRaiseAlarm() {

        // Arrange
        when(mockController.getReferenceSpeed()).thenReturn(150);

        // Act
        trainSensor.overrideSpeedLimit(50);

        // Assert
        verify(mockUser, atLeastOnce()).setAlarmState(true);
    }
}
