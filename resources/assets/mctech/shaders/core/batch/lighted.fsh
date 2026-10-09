#version 150

uniform vec4 ColorModulator;
uniform vec4 FogColor;
uniform sampler2D Sampler0;

in vec4 vertexColor;
in vec2 texCoord;

out vec4 fragColor;

void main() {
    vec4 base = texture(Sampler0, texCoord) * vertexColor * ColorModulator;
    if (base.a == 0.0) {
        discard;
    }
    vec3 albedo = base.rgb;
    vec3 emission = albedo;
    fragColor = vec4(emission, base.a);
}
