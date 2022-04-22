function res = Resistivitet(p, E, J)
if p == 0
	res = E/J;
elseif E == 0
	res = p/J;
elseif J == 0
	res = E/p;
end

