package Consumer;

import Producer.ProducerChild;

/**
 *  This class represents the south region.It implements the getRegion() Method
 *  declared as abstract in its parent ProductConsumer Class.
 * 
 * @author Tejal
 */
public class SouthRegionConsumer extends ProductConsumer{
    public SouthRegionConsumer()
    {}
    public SouthRegionConsumer(ProducerChild prodChild) {
		super(prodChild);
	} 
    @Override
	public synchronized char getRegion() {
		return 'S';
	} 
}
