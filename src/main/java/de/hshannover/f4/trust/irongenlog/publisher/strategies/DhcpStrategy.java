package de.hshannover.f4.trust.irongenlog.publisher.strategies;

import java.util.logging.Logger;
import org.codehaus.jackson.JsonNode;
import org.w3c.dom.Document;
import de.hshannover.f4.trust.ifmapj.*;
import de.hshannover.f4.trust.ifmapj.binding.*;
import de.hshannover.f4.trust.ifmapj.channel.*;
import de.hshannover.f4.trust.ifmapj.exception.*;
import de.hshannover.f4.trust.ifmapj.identifier.*;
import de.hshannover.f4.trust.ifmapj.messages.*;
import de.hshannover.f4.trust.irongenlog.publisher.PublishLogDataStrategy;

public class DhcpStrategy extends PublishLogDataStrategy {

    private static final Logger LOGGER = Logger.getLogger(DhcpStrategy.class.getName());

    @Override
    public void publishLogData(SSRC ssrc, JsonNode rootNode) {
    }

    public void blub1(SSRC ssrc, JsonNode rootNode){
    }

    public void blub2(SSRC ssrc, JsonNode rootNode){
    }

}