/*
 * Minecraft Forge
 * Copyright (c) 2016.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.event;

import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class ClientChatReceivedEvent extends Event
{
    private ITextComponent message;
    private final byte type;
    public ClientChatReceivedEvent(byte type, ITextComponent message)
    {
        this.type = type;
        this.setMessage(message);
    }

    public ITextComponent getMessage()
    {
        return message;
    }

    public void setMessage(ITextComponent message)
    {
        this.message = message;
    }

    /**
     * Introduced in 1.8:
     * 0 : Standard Text Message
     * 1 : 'System' message, displayed as standard text.
     * 2 : 'Status' message, displayed above action bar, where song notifications are.
     */
    public byte getType()
    {
        return type;
    }
}
