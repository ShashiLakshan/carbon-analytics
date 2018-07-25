/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.stream.processor.core.event.queue;

import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

public class EventQueue<E> {
    private static final Logger log = Logger.getLogger(EventQueue.class);

    private LinkedBlockingQueue<E> linkedBlockingQueue;

    public EventQueue(int queueSize) {
        linkedBlockingQueue = new LinkedBlockingQueue<>(queueSize);
    }

    public LinkedBlockingQueue<E> getQueue() {
        return linkedBlockingQueue;
    }

    public void enqueue(E object) {
        linkedBlockingQueue.offer(object);
    }

    public E dequeue() {
        return linkedBlockingQueue.poll();
    }

    public boolean trim(Predicate<? super E> filter) {
        return linkedBlockingQueue.removeIf(filter);
    }

    public boolean trimBasedOnTimestamp(Long timestamp) {
        return linkedBlockingQueue.removeIf(new Predicate<E>() {
            @Override
            public boolean test(E e) {
                QueuedEvent queuedEvent = (QueuedEvent) e;
                log.info("TRIMMED :       " + queuedEvent.getEvent().toString());
                return queuedEvent.getTimestamp() < timestamp;
            }
        });
    }

    public void clear() {
        linkedBlockingQueue.clear();
    }

    public int getRemainingCapacity() {
        return linkedBlockingQueue.remainingCapacity();
    }
}
