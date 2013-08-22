package Consumer;

import Producer.ProducerChild;

/**
 * This class represents the west region.It implements the getRegion() Method
 * declared as abstract in its parent ProductConsumer Class.
 *
 * @author Tejal
 */
public class WestRegionConsumer extends ProductConsumer {

    public WestRegionConsumer() {
    }

    public WestRegionConsumer(ProducerChild prodChild) {
        super(prodChild);
    }

    @Override
    public synchronized char getRegion() {
        return 'W';
    }
}
