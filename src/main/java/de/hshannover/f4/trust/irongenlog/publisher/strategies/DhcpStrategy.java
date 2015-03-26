package de.hshannover.f4.trust.irongenlog.publisher.strategies;

import java.util.logging.Logger;
import org.codehaus.jackson.JsonNode;
import org.w3c.dom.Document;
import de.hshannover.f4.trust.ifmapj.binding.*;
import de.hshannover.f4.trust.ifmapj.channel.*;
import de.hshannover.f4.trust.ifmapj.exception.*;
import de.hshannover.f4.trust.ifmapj.identifier.*;
import de.hshannover.f4.trust.ifmapj.messages.*;
import de.hshannover.f4.trust.ifmapj.metadata.*;
import de.hshannover.f4.trust.irongenlog.publisher.PublishLogDataStrategy;

public class DhcpStrategy extends PublishLogDataStrategy {

    private static final Logger LOGGER = Logger.getLogger(DhcpStrategy.class.getName());

    @Override
    public void publishLogData(SSRC ssrc, JsonNode rootNode) {
        {
        try {
            Identifier ident1 = Identifiers.createAr(rootNode.path( "MAC" ).getTextValue());
            Identifier ident2 = Identifiers.createDev(rootNode.path( "DHCPSERVERNAME" ).getTextValue());
            Document docMeta = getMetadataFactory().createUnexpectedBehavior(rootNode.path( "a" ).getTextValue(), rootNode.path( "b" ).getTextValue(), Integer.parseInt(rootNode.path( "c" ).getTextValue()), Integer.parseInt(rootNode.path( "d" ).getTextValue()), Significance.critical, rootNode.path( "f" ).getTextValue());
            PublishUpdate publishUpdate = Requests.createPublishUpdate(ident1, ident2, docMeta, MetadataLifetime.session);
            ssrc.publish(Requests.createPublishReq(publishUpdate));
        } catch (IfmapErrorResult e) {
            LOGGER.severe("Error publishing update data: " + e);
        } catch (IfmapException e) {
            LOGGER.severe("Error publishing update data: " + e);
        }
        }
        {
        try {
            Identifier ident1 = Identifiers.createMac(rootNode.path( "MAC" ).getTextValue());
            Identifier ident2 = Identifiers.createDev(rootNode.path( "DHCPSERVERNAME" ).getTextValue());
            String metaDeleteString = "meta:ip-mac[@ifmap-publisher-id='" + ssrc.getPublisherId() + "']";
            PublishDelete publishDelete = Requests.createPublishDelete(ident1, ident2, metaDeleteString);
            ssrc.publish(Requests.createPublishReq(publishDelete));
        } catch (IfmapErrorResult e) {
            LOGGER.severe("Error publishing update data: " + e);
        } catch (IfmapException e) {
            LOGGER.severe("Error publishing update data: " + e);
        }
        }
        {
        try {
            Identifier ident1 = Identifiers.createMac(rootNode.path( "MAC" ).getTextValue());
            Identifier ident2 = Identifiers.createDev(rootNode.path( "DHCPSERVERNAME" ).getTextValue());
            Document docMeta = getMetadataFactory().createDiscoveredBy();
            PublishNotify publishNotify = Requests.createPublishNotify(ident1, ident2, docMeta);
            ssrc.publish(Requests.createPublishReq(publishNotify));
        } catch (IfmapErrorResult e) {
            LOGGER.severe("Error publishing update data: " + e);
        } catch (IfmapException e) {
            LOGGER.severe("Error publishing update data: " + e);
        }
        }
    }

    public void blub(SSRC ssrc, JsonNode rootNode){
        {
        try {
            Identifier ident1 = Identifiers.createExtendedIdentity(rootNode.path( "MAC" ).getTextValue());
            String metaDeleteString = "meta:ip-mac[@ifmap-publisher-id='" + ssrc.getPublisherId() + "']";
            PublishDelete publishDelete = Requests.createPublishDelete(ident1, metaDeleteString);
            ssrc.publish(Requests.createPublishReq(publishDelete));
        } catch (IfmapErrorResult e) {
            LOGGER.severe("Error publishing update data: " + e);
        } catch (IfmapException e) {
            LOGGER.severe("Error publishing update data: " + e);
        }
        }
    }

}