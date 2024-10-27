package action;

import io.appium.java_client.MobileElement;

public class SwipeProperties {

    private final Direction direction;

    public Direction getDirection() {
        return direction;
    }

    private  final MobileElement element;

    public MobileElement getElement() {
        return element;
    }
    SwipeProperties (Builder builder){
        this.direction = builder.direction;
        this.element = builder.element;
    }

    public  static class Builder{
        Direction direction;
        MobileElement element;

        public  Builder direction(Direction direction){
            this.direction = direction;
            return this;
        }

        public  Builder element (MobileElement element){
         this.element = element;
         return this;
        }

        public SwipeProperties build(){
            return  new SwipeProperties(this);
        }
    }
}
