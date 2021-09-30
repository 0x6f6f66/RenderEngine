# RenderEngine

A 3D render engine which takes a mesh of values, expresses as a nested float array, and outputs them on a screen.

The render engine also supports tick() and render() methods to outline behaviour for individual objects creates for separate meshes. It also supports rotation for said mesh. 
A mesh is a group of N number of triangles, which are in turn are a group of 3 vertexes. 
A Vertex is a collection of 3 coordinates, X Y Z. Z coordinate represent depth.
The render endgine is able to take an object with a defined Z coordinate, and display it creating an illusion of that object being 3D.

# Mesh example

We imagine that 0.0 , 0.0 , 0.0 is the absolute center of the screen and space. 
The camera is not yet supported, so during the rendering phase the object has to be moved forwards by incrementing the Z value in the render() method. (This is unnecesary if the user is using the default Figure() class).

This is an example of a mesh being rendered by default.
Note the comments which represent the individual sides of the cube.
    //front
    {-0.5f, 0.5f, -0.5f}, {-0.5f, -0.5f, -0.5f}, {0.5f, -0.5f, -0.5f},
    {-0.5f, 0.5f, -0.5f}, {0.5f, -0.5f, -0.5f}, {0.5f, 0.5f, -0.5f},

    //top
    {-0.5f, -0.5f, -0.5f}, {-0.5f, -0.5f, 0.5f}, {0.5f, -0.5f, 0.5f},
    {-0.5f, -0.5f, -0.5f}, {0.5f, -0.5f, 0.5f}, {0.5f, -0.5f, -0.5f},

    //right
    {0.5f, 0.5f, -0.5f}, {0.5f, -0.5f, -0.5f}, {0.5f, -0.5f, 0.5f},
    {0.5f, 0.5f, -0.5f}, {0.5f, -0.5f, 0.5f}, {0.5f, 0.5f, 0.5f},

    //left
    {-0.5f, 0.5f, 0.5f}, {-0.5f, -0.5f, 0.5f}, {-0.5f, -0.5f, -0.5f},
    {-0.5f, 0.5f, 0.5f}, {-0.5f, -0.5f, -0.5f}, {-0.5f, 0.5f, -0.5f},

    //bottom
    {-0.5f, 0.5f, 0.5f}, {-0.5f, 0.5f, -0.5f}, {0.5f, 0.5f, -0.5f},
    {-0.5f, 0.5f, 0.5f}, {0.5f, 0.5f, -0.5f}, {0.5f, 0.5f, 0.5f},

    //back
    {0.5f, 0.5f, 0.5f}, {0.5f, -0.5f, 0.5f}, {-0.5f, -0.5f, 0.5f},
    {0.5f, 0.5f, 0.5f}, {-0.5f, -0.5f, 0.5f}, {-0.5f, 0.5f, 0.5f}

Every 3 floats are a coordinate. Every 3 coordinates are a Vertex. Every 3 Vertexes are a Triangle.
The app takes control of organising values into an object, so all that is left to do is to write the values down as a set of nested float array.
