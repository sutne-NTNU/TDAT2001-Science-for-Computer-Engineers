function res = PotensialIUniformtFelt(V, E, d)
if V == 0
	res = E * d;
elseif E == 0
	res = V/d;
elseif d == 0
	res = V/E;
end

