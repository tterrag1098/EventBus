package net.minecraftforge.eventbus.api;

import net.minecraftforge.eventbus.EventBus;

/**
 * Build a bus
 */
public final class BusBuilder {
    private IEventExceptionHandler exceptionHandler;

    // true by default
    private boolean trackPhases = true;
    private boolean startShutdown = false;
    private Class<? extends Event> baseType;

    public static BusBuilder builder() {
        return new BusBuilder();
    }

    public BusBuilder setTrackPhases(boolean trackPhases) {
        this.trackPhases = trackPhases;
        return this;
    }

    public BusBuilder setExceptionHandler(IEventExceptionHandler handler) {
        this.exceptionHandler =  handler;
        return this;
    }

    public BusBuilder startShutdown() {
        this.startShutdown = true;
        return this;
    }
    
    public BusBuilder baseType(Class<? extends Event> type) {
        this.baseType = type;
        return this;
    }
    
    public IEventExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public boolean getTrackPhases() {
        return trackPhases;
    }

    public IEventBus build() {
        return new EventBus(this);
    }

    public boolean isStartingShutdown() {
        return this.startShutdown;
    }
    
    public Class<? extends Event> getBaseType() {
        return this.baseType;
    }
}
