package org.bonn.se.carlook.test.util;

import org.bonn.se.carlook.model.factories.VertrieblerFactory;
import org.bonn.se.carlook.model.objects.entities.Vertriebler;

public class VertrieblerBuilder {


private Vertriebler vertriebler =null;

public VertrieblerBuilder createNewCompany(){
        vertriebler = VertrieblerFactory.createEntity();

        return this;

        }

        }