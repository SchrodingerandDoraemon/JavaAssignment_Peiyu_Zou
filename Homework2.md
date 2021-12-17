## Memcache

Memcached is a simple, open-source, in-memory caching system that can be used as a temporary ***in-memory data storage***. The stored data in memory has high read and write performance and distributes data into multiple servers. It is a key-value of string object that is stored in memory and the API is available for ***all*** the languages. Memcached is very efficient for websites. 

## Difference between Redis and Memcached
| Parameter |	REDIS |	MEMCACHED |
| ----------| ----- | --------- |
| Cores Used |	It uses single cores. Single thread. | It uses multiple cores. Multithread. |
| Length of a key | In Redis, maximum key length is 2GB. | In Memcached, maximum key length is 250 bytes. |
| Data Structure | It uses list, string, hashes, sorted sets and bitmaps as data structure. |	It uses only string and integers as data structure. | 
| Speed | It reads and writes speed is slower than Memcached.	| It reads and writes speed is higher than Redis. |
| Replication |	It supports Master-Slave Replication and Multi-Master Replication methods. | It does not support any replication method. |
| Durability | It is more durable than Memcached. |	It is less durable than Redis. |
| Secondary database model | It has Document Store, Graph DBMS, Search Engine, and Time Series DBMS as secondary database models. |	It has no secondary database models.|
| Persistence |	It uses persistent data. | It does not use persistent data. |
| Partitioning method |	It supports Sharding.	| It does not support any partitioning method. |

## Amazon ElastiCache
Amazon ElastiCache is a web service that makes it easy to deploy and run Memcached or Redis in the cloud. It improves the performance of web applications by allowing you to retrieve information from a fast, managed, in-memory system, instead of relying entirely on slower disk-based databases.

## Vertical scaling vs horizontal scaling
Horizontal scaling means that you scale out by adding more machines into your pool of resources.
Vertical scaling means that you scale by adding more power (CPU, RAM) to an
 existing machine.

## Hierarchical database
A hierarchical database is a data model in which data is stored in the form of records and organized into a ***tree-like structure***, or parent-child structure, in which one parent node can have many child nodes connected through links.

## BASE principle
Basically Available: Guarantees the availability of the data . There will be a response to any request (can be failure too).
Soft state: The state of the system could change over time.
Eventual consistency: The system will eventually become consistent once it stops receiving input.

## view
A view represents a virtual table.  A view also has rows and columns as they are in a real table in the database. We can create a view by selecting fields from one or more tables present in the database.

### Why do we use rows? 
1. Restricting data access: iews provide an additional level of table security by restricting access to a predetermined set of rows and columns of a table.
2. Hiding data complexity: A view can hide the complexity that exists in a multiple table join.

## stored procedure
A stored procedure is a group of statements that can be executed, it is like a function. it is best for updating and inserting data, or returning single values or data sets. Stored procedure could be saved and shared.
