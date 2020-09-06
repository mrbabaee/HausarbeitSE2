package org.bonn.se.carlook.test.util;

import org.bonn.se.carlook.model.factories.KundeFactory;
import org.bonn.se.carlook.model.objects.entities.Kunde;

public class KundeBuilder extends GenericBuilder<KundeBuilder, Kunde>{

    public KundeBuilder createNewStudent() {
        super.entity = KundeFactory.createEntity();
        return this;
    }
}
