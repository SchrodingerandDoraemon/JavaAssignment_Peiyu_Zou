# Homework 3

## Optimistic lock and pessimistic lock
Optimistic locking is used when you don't expect many collisions. It costs less to do a normal operation. When the transaction is done, it will check the version of record(involve dates, timestamps or checksums/hashes), if it it dirty, it abort the transaction and the user can re-start it. This strategy is most applicable to high-volume systems and three-tier architectures 

Pessimistic locking is when you lock the record for your exclusive use until you have finished with it. It has much better integrity than optimistic locking but requires you to be careful with your application design to avoid Deadlocks. Pesimisticis used when a collision is anticipated. The transactions which would violate synchronization are simply blocked.

pessimistic locking might be more suitable when conflicts happen frequently, as it reduces the chance of rolling back transactions.

## How to solve the deadlock?
#### ignoring deadlock: 
This is used when the time intervals between occurrences of deadlocks are large and the data loss incurred each time is tolerable.Ignoring deadlocks can be safely done if deadlocks are formally proven to never occur

#### Detection
1. Process termination: one or more processes involved in the deadlock may be aborted.
2. Resource preemption: resources allocated to various processes may be successively preempted and allocated to other processes until the deadlock is broken

#### Prevention
1. Removing the mutual exclusion condition means that no process will have exclusive access to a resource. 
2. The hold and wait or resource holding conditions may be removed by requiring processes to request all the resources they will need before starting up 
3. The no preemption condition may also be difficult or impossible to avoid as a process has to be able to have a resource for a certain amount of time, or the processing outcome may be inconsistent or thrashing may occur. 
cancelling and restarting the first process.
4. The final condition is the circular wait condition. Approaches that avoid circular waits include disabling interrupts during critical sections and using a hierarchy to determine a partial ordering of resources. If no obvious hierarchy exists, even the memory address of resources has been used to determine ordering and resources are requested in the increasing order of the enumeration.

## Saga design pattern:
The Saga design pattern is a way to manage data consistency across microservices in distributed transaction scenarios. A saga is a sequence of transactions that updates each service and publishes a message or event to trigger the next transaction step. If a step fails

Transactions must be atomic, consistent, isolated, and durable (ACID). Transactions within a single service are ACID, but cross-service data consistency requires a cross-service transaction management strategy.

Distributed transactions like the two-phase commit (2PC) protocol require all participants in a transaction to commit or roll back before the transaction can proceed. However some participant implementations, such as NoSQL databases and message brokering, don't support this model.

### Solution
The Saga pattern provides transaction management using a sequence of local transactions. A local transaction is the atomic work effort performed by a saga participant. Each local transaction updates the database and publishes a message or event to trigger the next local transaction in the saga. If a local transaction fails, the saga executes a series of compensating transactions that undo the changes that were made by the preceding local transactions.

There are two common saga implementation approaches, choreography and orchestration. Each approach has its own set of challenges and technologies to coordinate the workflow.

### Choreography
Choreography is a way to coordinate sagas where participants exchange events without a centralized point of control. With choreography, each local transaction publishes domain events that trigger local transactions in other services.

<img width="464" alt="Screen Shot 2021-12-17 at 10 42 07 PM" src="https://user-images.githubusercontent.com/35554521/146627743-b35cc2b5-ac11-45e1-b39a-d8262bc74fd4.png">

#### Benefits
	Good for simple workflows that require few participants and don't need a coordination logic.
	Doesn't require additional service implementation and maintenance.
	Doesn't introduce a single point of failure, since the responsibilities are distributed across the saga participants.

#### Drawbacks
	Workflow can become confusing when adding new steps, as it's difficult to track which saga participants listen to which commands.
	There's a risk of cyclic dependency between saga participants because they have to consume each other's commands.
	Integration testing is difficult because all services must be running to simulate a transaction.


#### Orchestration
Orchestration is a way to coordinate sagas where a centralized controller tells the saga participants what local transactions to execute. The saga orchestrator handles all the transactions and tells the participants which operation to perform based on events. The orchestrator executes saga requests, stores and interprets the states of each task, and handles failure recovery with compensating transactions.

<img width="408" alt="Screen Shot 2021-12-17 at 10 43 00 PM" src="https://user-images.githubusercontent.com/35554521/146627759-93436aa4-ac9b-4472-b79a-8f1049dacaa4.png">

#### Benefits
	1. Good for complex workflows involving many participants or new participants added over time.
	2. Suitable when there is control over every participant in the process, and control over the flow of activities.
	3. Doesn't introduce cyclical dependencies, because the orchestrator unilaterally depends on the saga participants.
	4. Saga participants don't need to know about commands for other participants. Clear separation of concerns simplifies business logic.

##### Drawbacks
	1. Additional design complexity requires an implementation of a coordination logic.
	2. There's an additional point of failure, because the orchestrator manages the complete workflow.

### When to use this pattern
#### Use the Saga pattern when you need to:
	1. Ensure data consistency in a distributed system without tight coupling.
	2. Roll back or compensate if one of the operations in the sequence fails.
#### The Saga pattern is less suitable for:
	1. Tightly coupled transactions.
	2. Compensating transactions that occur in earlier participants.
	3. Cyclic dependencies.
